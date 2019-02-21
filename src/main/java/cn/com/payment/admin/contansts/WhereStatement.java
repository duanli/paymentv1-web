package cn.com.payment.admin.contansts;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * where 语句
 */
@SuppressWarnings("serial")
public class WhereStatement implements Serializable {

	protected String orderByClause;

	protected List<Criteria> oredCriteria = new ArrayList<Criteria>();

	protected int limitStart = -1;

	protected int count = -1;

	public void setOrderByClause(String orderByClause) {
		this.orderByClause = orderByClause;
	}

	public String getOrderByClause() {
		return orderByClause;
	}

	public List<Criteria> getOredCriteria() {
		return oredCriteria;
	}

	public void where(Criteria where) {
		this.oredCriteria.add(where);
	}

	public void clear() {
		oredCriteria.clear();
		orderByClause = null;
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

	public static Criteria newCriteria() {
		return new Criteria();
	}

	public static class Builder {

		private WhereStatement bulider = new WhereStatement();

		public Builder or(Criteria where) {

			bulider.where(where);
			return this;
		}

		public Builder orderBy(String orderBy) {
			bulider.setOrderByClause(orderBy);
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

		public WhereStatement bulider() {
			return bulider;
		}

	}

	public static class Criteria {

		protected List<Criterion> criteria;

		public Criteria() {
			criteria = new ArrayList<Criterion>();
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
			criteria.add(new Criterion(condition));

		}

		private void addCriterion(String condition, Object value, String property) {
			if (value == null) {
				throw new RuntimeException("Value for " + property + " cannot be null");
			}
			criteria.add(new Criterion(condition, value));
		}

		private void addCriterion(String condition, Object value1, Object value2, String property) {
			if (value1 == null || value2 == null) {
				throw new RuntimeException("Between values for " + property + " cannot be null");
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
			}
			else {
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