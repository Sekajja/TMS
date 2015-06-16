package project.iics.tms.services;

import java.util.List;

import project.iics.tms.domain.Component;

public interface ComponentService {

	public void createNewComponent(Component component);

	public List<Component> getComponent();

	/* public List<ProjectUser> getProjectUserByUserName(String username); */

	public Component getComponent(Long id);

	public void updateComponent(Component component);

	public void deleteComponent(Long id);
}
