package vn.ifisolution.fresher12.RedmineApi.repository;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import vn.ifisolution.fresher12.RedmineApi.entityRedmine.ProjectEntity;

public interface ProjectEntityRepository extends ElasticsearchRepository<ProjectEntity, Integer>{

}
