package vn.ifisolution.fresher12.RedmineApi.repository;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import vn.ifisolution.fresher12.RedmineApi.entityRedmine.IssueEntity;
@Repository
public interface IssueEntityRepository extends ElasticsearchRepository<IssueEntity, Integer>{

}
