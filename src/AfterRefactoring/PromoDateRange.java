package AfterRefactoring;

import java.util.Date;

//Refactoring Smell 31: The Bloater - Data Clumps
public class PromoDateRange {
	private Date promoStart;
	private Date promoEnd;
	public PromoDateRange(Date promoStart, Date promoEnd) {
		this.promoStart = promoStart;
		this.promoEnd = promoEnd;
	}
	public Date getPromoStart() {
		return promoStart;
	}
	public void setPromoStart(Date promoStart) {
		this.promoStart = promoStart;
	}
	public Date getPromoEnd() {
		return promoEnd;
	}
	public void setPromoEnd(Date promoEnd) {
		this.promoEnd = promoEnd;
	}
}