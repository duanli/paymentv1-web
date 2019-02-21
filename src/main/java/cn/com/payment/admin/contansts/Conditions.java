package cn.com.payment.admin.contansts;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * where 语句
 */
@SuppressWarnings("serial")
public class Conditions implements Serializable {

	/**
	 * 排序
	 */
	protected List<OrderBy> orderBy = new ArrayList<OrderBy>();

	/**
	 * and条件集合
	 */
	protected List<Criteria> andCriterion = new ArrayList<Criteria>();
	/**
	 * or条件集合
	 */
	protected List<Criteria> orCriterion = new ArrayList<Criteria>();

	protected int limitStart = -1;
	protected String perfix = "";
	protected int count = -1;

	public List<Criteria> getAndCriterion() {
		return andCriterion;
	}

	public List<Criteria> getOrCriterion() {
		return orCriterion;
	}

	public void orderBy(OrderBy orderBy) {
		orderBy.setPropery(perfix + orderBy.getPropery());
		this.orderBy.add(orderBy);
	}

	public void and(Criteria where) {
		this.andCriterion.add(where);
	}

	public void or(Criteria where) {
		this.orCriterion.add(where);
	}

	public void clear() {
		orCriterion.clear();
		andCriterion.clear();
		orderBy.clear();
	}

	public void setLimitStart(int limitStart) {
		this.limitStart = limitStart;
	}

	public int getLimitStart() {
		return limitStart;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public int getCount() {
		return count;
	}

	public static Builder newInstance() {
		return new Builder();
	}

	public static Builder newInstance(String perfix) {

		return new Builder(perfix);
	}

	public static Criteria newOrCriteria() {
		return new Criteria("OR");
	}

	public static Criteria newAndCriteria() {
		return new Criteria();
	}

	public static class OrderBy {
		private String propery;
		private Sort sort;

		public Sort getSort() {
			return sort;
		}

		public void setSort(Sort sort) {
			this.sort = sort;
		}

		public String getPropery() {
			return propery;
		}

		public void setPropery(String propery) {
			this.propery = propery;
		}

	}

	public static class Builder {

		public Builder() {
		}

		public Builder(String perfix) {
			bulider.perfix = perfix;
			this.setPerfix(perfix);
		}

		private String perfix = "";

		private Conditions bulider = new Conditions();

		public Builder or(Criteria criteria) {
			bulider.or(criteria);
			return this;
		}

		public Builder and(Criteria criteria) {
			bulider.and(criteria);
			return this;
		}

		public Builder orderBy(OrderBy orderBy) {
			bulider.orderBy(orderBy);
			return this;
		}

		public Builder limitStart(int limitStart) {
			bulider.setLimitStart(limitStart);
			return this;
		}

		public Builder count(int count) {
			bulider.setCount(count);
			return this;
		}

		public Conditions bulider() {
			return bulider;
		}

		public String getPerfix() {
			return perfix;
		}

		public void setPerfix(String perfix) {
			this.perfix = perfix;
		}

	}

	public static class Criteria {

		protected String perfix;
		/**
		 * 与其它条件集合的关系 AND 或 OR
		 */
		protected String relation;

		protected List<Criterion> criteria;

		public Criteria() {
			criteria = new ArrayList<Criterion>();
			relation = " AND ";
		}

		/**
		 * 
		 * @param relation
		 *            与其它条件集合的关系，取值 OR 或 AND
		 */
		public Criteria(String relation) {
			criteria = new ArrayList<Criterion>();
			relation = " " + relation + " ";

		}

		public void setPerfix(String perfix) {
			this.perfix = perfix;
		}

		public String getRelation() {
			return relation;
		}

		public boolean isValid() {
			return criteria.size() > 0;
		}

		public List<Criterion> getAllCriteria() {
			return criteria;
		}

		public List<Criterion> getCriteria() {
			return criteria;
		}

		private void addCriterion(String condition) {
			if (condition == null) {
				throw new RuntimeException("Value for condition cannot be null");
			}

			if (perfix != "")
				condition += perfix;

			criteria.add(new Criterion(condition));

		}

		private void addCriterion(String condition, Object value, String property) {
			if (value == null) {
				throw new RuntimeException("Value for " + property + " cannot be null");
			}

			if (perfix != "") {
				condition += perfix;
				property += perfix;
			}

			criteria.add(new Criterion(condition, value));
		}

		private void addCriterion(String condition, Object value1, Object value2, String property) {
			if (value1 == null || value2 == null) {
				throw new RuntimeException("Between values for " + property + " cannot be null");
			}

			if (perfix != "") {
				condition += perfix;
				property += perfix;
			}

			criteria.add(new Criterion(condition, value1, value2));
		}

		public Criteria isNull(String property) {
			addCriterion(property + " is null");
			return (Criteria) this;
		}

		public Criteria isNotNull(String property) {
			addCriterion(property + " is not null");
			return (Criteria) this;
		}

		public <T> Criteria equalTo(String property, T value) {
			addCriterion(property + " = ", value, property);
			return (Criteria) this;
		}

		public <T> Criteria notEqualTo(String property, T value) {
			addCriterion(property + " <> ", value, property);
			return (Criteria) this;
		}

		public <T> Criteria greaterThan(String property, T value) {
			addCriterion(property + " >", value, property);
			return (Criteria) this;
		}

		public <T> Criteria thanOrEqualTo(String property, T value) {
			addCriterion(property + " >=", value, property);
			return (Criteria) this;
		}

		public <T> Criteria lessThan(String property, T value) {
			addCriterion(property + " <", value, property);
			return (Criteria) this;
		}

		public <T> Criteria lessThanOrEqualTo(String property, T value) {
			addCriterion(property + " <=", value, property);
			return (Criteria) this;
		}

		public <T> Criteria in(String property, List<T> values) {
			addCriterion(property + " in ", values, property);
			return (Criteria) this;
		}

		public <T> Criteria notIn(String property, List<T> values) {
			addCriterion(property + " not in", values, property);
			return (Criteria) this;
		}

		public <T> Criteria between(String property, T value1, T value2) {
			addCriterion(property + "  between", value1, value2, property);
			return (Criteria) this;
		}

		public <T> Criteria notBetween(String property, T value1, T value2) {
			addCriterion(property + " not  between", value1, value2, property);
			return (Criteria) this;
		}

	}

	public static class Criterion {
		private String condition;

		private Object value;

		private Object secondValue;

		private boolean noValue;

		private boolean singleValue;

		private boolean betweenValue;

		private boolean listValue;

		private String typeHandler;

		public String getCondition() {
			return condition;
		}

		public Object getValue() {
			return value;
		}

		public Object getSecondValue() {
			return secondValue;
		}

		public boolean isNoValue() {
			return noValue;
		}

		public boolean isSingleValue() {
			return singleValue;
		}

		public boolean isBetweenValue() {
			return betweenValue;
		}

		public boolean isListValue() {
			return listValue;
		}

		public String getTypeHandler() {
			return typeHandler;
		}

		protected Criterion(String condition) {
			super();
			this.condition = condition;
			this.typeHandler = null;
			this.noValue = true;
		}

		protected Criterion(String condition, Object value, String typeHandler) {
			super();
			this.condition = condition;
			this.value = value;
			this.typeHandler = typeHandler;
			if (value instanceof List<?>) {
				this.listValue = true;
			} else {
				this.singleValue = true;
			}
		}

		protected Criterion(String condition, Object value) {
			this(condition, value, null);
		}

		protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
			super();
			this.condition = condition;
			this.value = value;
			this.secondValue = secondValue;
			this.typeHandler = typeHandler;
			this.betweenValue = true;
		}

		protected Criterion(String condition, Object value, Object secondValue) {
			this(condition, value, secondValue, null);
		}
	}
}