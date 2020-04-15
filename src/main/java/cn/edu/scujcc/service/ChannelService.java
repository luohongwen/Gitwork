package cn.edu.scujcc.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import cn.edu.scujcc.dao.ChannelRepository;
import cn.edu.scujcc.model.Channel;
@Service
public class ChannelService {
	@Autowired
	private ChannelRepository repo;	
//    private List<Channel> channels;
//     //ģ������10������
//     public ChannelService() {
// 		channels=new ArrayList<>();
// 		for (int i=0;i<10;i++) {
// 			Channel c=new Channel();
//// 			c.setId(i+1);
// 			c.setTitle("����"+(i+1)+"̨");
// 			c.setUrl("http://www.cctv.com");
// 			channels.add(c);
// 			
// 		}
//     }
     
     
     /**
      * ��ȡ����Ƶ��
      * @return
      */   
     public List<Channel> getAllChannels(){
    	 return repo.findAll();
    }
     
     
     /**
      * ��ȡһ��Ƶ��
      * @param channelId
      * @return
      */
     public Channel getChannel(String channelId) {
  	   Optional<Channel> result=repo.findById(channelId);
  	   //ѭ������
//  	   for(Channel c:channels) {
//  		   if(c.getId() == channelId) {
//  			   result=c;
//  			   break;
//  		   }
//  	   }
//  	   return result;
  	   if (result.isPresent()) {
  		   return result.get();
  	   }else {
  		   return null;
  	   }
     }
     
     
    /**
     * ɾ��ָ��Ƶ�� 
     * @param channelId
     * @return
     */
     public boolean deleteChannel(String channelId) {
  	   boolean result= true;
//  	   Channel c=getChannel(channelId);
  	   repo.deleteById(channelId);
//  	   if(c!=null) {
//  		   channels.remove(c);
//  		   result=true;
//  		   }	   
  	   return result;
  	   }
     
     /**
      * ����Ƶ��
      * @param c
      * @return
      */
     public Channel createChannel(Channel c) {
//  	   int newId =channels.get(channels.size() - 1).getId()+1;
//  	   c.setId(newId);
//  	   channels.add(c);
  	   return repo.save(c);
     }
     
     /**
      * ָ������Ƶ��..
      * @param c
      * @return
      */
     public Channel updateChannel(Channel c) {
//  	   Channel toUpdate=getChannel(c.getId());
//  	   if(toUpdate !=null) {
//  		   toUpdate.setTitle(c.getTitle());
//  		   toUpdate.setQuality(c.getQuality());
//  		   toUpdate.setUrl(c.getUrl());
//  	   }
//  	   return toUpdate;
    	 Channel saved = getChannel(c.getId());
    	 if(c.getTitle() !=null) {
    		 saved.setTitle(c.getTitle());
    	 }
    	 if(c.getQuality() !=null) {
    		 saved.setQuality(c.getQuality());
    	 }
    	 if(c.getUrl() !=null) {
    		 saved.setUrl(c.getUrl());
    	 }
    	 //��������׷�ӵ������ۺ���
    	 if(c.getComments() !=null) {
    		 if(saved.getComments() !=null) {
    			 saved.getComments().addAll(c.getComments());	 
    	     }else {//�������۴����ϵĿ�����
    		      saved.setComments(c.getComments());
    	     }
    	 } 
    	 return repo.save(saved);//������º��ʵ�����
     }
     
     public List<Channel> searchByQuality(String quality ){
    	 return repo.findByQuality(quality);
     }
     
     /**
      * ��ȡ����Ƶ��..
      */
     public List<Channel> findColdChannels() {
    	 return repo.findByCommentsNull();
     }
     
     public List<Channel> findChannelsPage(int page){
    	 Page<Channel> p = repo.findAll(PageRequest.of(page, 3));
    	 return p.toList();
     }
}
     
