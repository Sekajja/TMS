package project.iics.tms.repository_impl;

import org.springframework.stereotype.Repository;

import project.iics.tms.domain.Component;
import project.iics.tms.repository.ComponentDao;

@Repository("componentDao")
public class ComponentDaoImpl extends AbstractHbnDao<Component> implements ComponentDao{

}
