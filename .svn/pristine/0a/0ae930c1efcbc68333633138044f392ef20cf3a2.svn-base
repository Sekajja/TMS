package project.iics.tms.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Component implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3916343933010735990L;
	private Long id;
	private String componentName;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Column
	public String getComponentName() {
		return componentName;
	}

	public void setComponentName(String componentName) {
		this.componentName = componentName;
	}

	@Override
	public String toString() {
		return "Component [id=" + id + ", componentName=" + componentName + "]";
	}

}
