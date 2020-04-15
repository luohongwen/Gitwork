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
//     //模拟生成10条数据
//     public ChannelService() {
// 		channels=new ArrayList<>();
// 		for (int i=0;i<10;i++) {
// 			Channel c=new Channel();
//// 			c.setId(i+1);
// 			c.setTitle("中央"+(i+1)+"台");
// 			c.setUrl("http://www.cctv.com");
// 			channels.add(c);
// 			
// 		}
//     }
     
     
     /**
      * 获取所有频道
      * @return
      */   
     public List<Channel> getAllChannels(){
    	 return repo.findAll();
    }
     
     
     /**
      * 获取一个频道
      * @param channelId
      * @return
      */
     public Channel getChannel(String channelId) {
  	   Optional<Channel> result=repo.findById(channelId);
  	   //循环查找
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
     * 删除指定频道 
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
      * 保存频道
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
      * 指定更新频道..
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
    	 //把新评论追加到老评论后面
    	 if(c.getComments() !=null) {
    		 if(saved.getComments() !=null) {
    			 saved.getComments().addAll(c.getComments());	 
    	     }else {//用新评论代替老的空评论
    		      saved.setComments(c.getComments());
    	     }
    	 } 
    	 return repo.save(saved);//保存更新后的实体对象
     }
     
     public List<Channel> searchByQuality(String quality ){
    	 return repo.findByQuality(quality);
     }
     
     /**
      * 获取冷门频道..
      */
     public List<Channel> findColdChannels() {
    	 return repo.findByCommentsNull();
     }
     
     public List<Channel> findChannelsPage(int page){
    	 Page<Channel> p = repo.findAll(PageRequest.of(page, 3));
    	 return p.toList();
     }
}
     
