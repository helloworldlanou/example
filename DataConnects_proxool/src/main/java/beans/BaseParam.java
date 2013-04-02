package beans;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * 
 * @author Joey
 * 
 */
public class BaseParam implements Serializable {

	/**
	 * Client param for OCA
	 * 
	 * Type : Client
	 */
	public static final String PARAM_BASE_CLIENT = "clientParam";

	private Map<String, Object> params = new HashMap<String, Object>();

	public Map<String, Object> getParams() {
		return params;
	}

	public void setParams(Map<String, Object> params) {
		this.params = params;
	}

	/**
	 * Get the param in params-map by paramKey
	 * 
	 * @param paramKey
	 *            the key of param
	 * @return
	 */
	public Object getParam(String paramKey) {
		return params.get(paramKey);
	}

	/**
	 * @param paramKey
	 * @param paramValue
	 */
	public void addParam(String paramKey, Object paramValue) {
		this.params.put(paramKey, paramValue);
	}

}
