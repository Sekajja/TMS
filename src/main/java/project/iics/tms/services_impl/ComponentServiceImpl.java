package project.iics.tms.services_impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import project.iics.tms.domain.Component;
import project.iics.tms.repository.ComponentDao;
import project.iics.tms.services.ComponentService;


@Transactional
@Service("componentService")
public class ComponentServiceImpl implements ComponentService {

	@Autowired
	private ComponentDao componentDao;
	
	@Override
	public void createNewComponent(Component component) {
		componentDao.create(component);
	}

	@Override
	public List<Component> getComponent() {
		return componentDao.getAll();
	}

	@Override
	public Component getComponent(Long id) {
		return componentDao.get(id);
	}

	@Override
	public void updateComponent(Component component) {
		componentDao.update(component);
		
	}

	@Override
	public void deleteComponent(Long id) {
		componentDao.deleteById(id);		
	}

}
