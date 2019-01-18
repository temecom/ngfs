package net.temecom.ngfs.model;

import javax.persistence.Entity;

@Entity
public class Enumeration extends EntityBase {

		private String name;
		private String code;
		private int defaultSortOrder;
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getCode() {
			return code;
		}
		public void setCode(String code) {
			this.code = code;
		}
		public int getDefaultSortOrder() {
			return defaultSortOrder;
		}
		public void setDefaultSortOrder(int defaultSortOrder) {
			this.defaultSortOrder = defaultSortOrder;
		} 
}
