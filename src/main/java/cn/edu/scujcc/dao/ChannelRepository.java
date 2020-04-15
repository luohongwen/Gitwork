package cn.edu.scujcc.dao;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import cn.edu.scujcc.model.Channel;

@Repository
public interface ChannelRepository extends MongoRepository<Channel, String> {
 public List<Channel> findByQuality(String q);
 public Channel findFirstByQuality(String q);
 /**
  * 找出没有评论的频道
  */
 public List<Channel> findByCommentsNull();
}
