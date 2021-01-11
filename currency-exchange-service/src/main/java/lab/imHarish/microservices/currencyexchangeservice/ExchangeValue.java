package lab.imHarish.microservices.currencyexchangeservice;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class ExchangeValue {

	@Id
	private Long id;
	private String exchangeFrom;
	private String exchangeTo;
	private BigDecimal conversionMultiple;
	private int port;

	public ExchangeValue(Long id, String exchangeFrom, String exchangeTo, BigDecimal conversionMultiple, int port) {
		this.id = id;
		this.exchangeFrom = exchangeFrom;
		this.exchangeTo = exchangeTo;
		this.conversionMultiple = conversionMultiple;
		this.port = port;
	}

	public ExchangeValue() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getExchangeFrom() {
		return exchangeFrom;
	}

	public void setExchangeFrom(String exchangeFrom) {
		this.exchangeFrom = exchangeFrom;
	}

	public String getExchangeTo() {
		return exchangeTo;
	}

	public void setExchangeTo(String exchangeTo) {
		this.exchangeTo = exchangeTo;
	}

	public BigDecimal getConversionMultiple() {
		return conversionMultiple;
	}

	public void setConversionMultiple(BigDecimal conversionMultiple) {
		this.conversionMultiple = conversionMultiple;
	}

	public int getPort() {
		return port;
	}

	public void setPort(int port) {
		this.port = port;
	}

	@Override
	public String toString() {
		return "ExchangeValue [id=" + id + ", exchangeFrom=" + exchangeFrom + ", exchangeTo=" + exchangeTo
				+ ", conversionMultiple=" + conversionMultiple + ", port=" + port + "]";
	}

}
