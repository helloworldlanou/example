package hdty.project.system.face;

import java.util.Date;
import java.util.Map;

import javax.faces.component.UIData;
import javax.faces.context.FacesContext;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;

import hdty.project.system.service.PersonService;
import hdty.project.system.vo.PersonVO;

/**
 * 员工管理BackingBean
 * 
 * @author wangzhuo
 * @version 1.0
 */
public class PersonFace {
	private PersonVO person;
	private String id;

	/** 为DataTable显示行号而设置的 */
	private UIData table;

	private PersonService service;

	public PersonFace() {
		service = new PersonService();
		
		//如果请求参数中有emplId,就根据这个ID获取该员工实例,否则创建一个新实例
		FacesContext fc = FacesContext.getCurrentInstance();
		Map requestParams = fc.getExternalContext().getRequestParameterMap();
		id = (String) requestParams.get("personId");
		if (id != null){
			person = service.queryDetail(new Integer(id));
		}else
			person = new PersonVO();	    
	}

	public String insertAction() {		
		person.setBirthday(new Date());
		this.service.insert(person);
		return "inserted";
	}

	public String updateAction() {		
		this.service.update(person);
		return "updated";
	}

	public String deleteAction() {
		this.service.delete(person);
		return "deleted";
	}
	
	
	public DataModel getAllPersons() {
		return new ListDataModel(this.service.queryList());
	}

	
	public PersonVO getPerson() {
		return person;
	}

	public void setPerson(PersonVO person) {
		this.person = person;
	}

	public UIData getTable() {
		return table;
	}

	public void setTable(UIData table) {
		this.table = table;
	}

}
