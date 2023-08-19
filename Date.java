package date;

public class Date {
	private int day;
	private int month;
	private int year;
	
	public static final int MAX_MONTH = 12;
	public static final int MAX_DAY = 31;
	public static final int MIN_MONTH = 1;
	public static final int MIN_DAY = 1;
	
	public Date(int new_dd , int new_mm , int new_yyyy) {
		day = new_dd;
		month = new_mm;
		year = new_yyyy;
	}
	
	public boolean isValidDate() {
        if (year < 1 || month < MIN_MONTH || month > MAX_MONTH || day < 1 || day > MAX_DAY)
            return false;

        if (month == 2) {
        
            if ((year % 4 == 0 && year % 100 != 0) || year % 400 == 0) {
                return day <= 29;
            } else {
                return day <= 28;
            }
        } else if (month == 4 || month == 6 || month == 9 || month == 11) {
            return day <= 30;
        } else {
            return day <= 31;
        }
    }
	
	public Date nextDate() {
		if(!isValidDate()) {
			//do something
		}
		
		int nextY = year;
		int nextM = month;
		int nextD = day+1;
		
		if(nextD >MAX_DAY) {
			nextD = 1;
			nextM +=1; 
			
			if(nextM > MAX_MONTH) {
				nextM = 1;
				nextY +=1;
			}
		}
		return new Date(nextD , nextM , nextY);
	}
	
	public Date prevDate() {
		if(!isValidDate()) {
			//do something
		}
		
		int prevY = year;
		int prevM = month;
		int prevD = day-1;
		
		if(prevD < MIN_DAY) {
			prevM-=1;
			if(prevM < MIN_MONTH) {
				prevM=12;
				prevY-=1;
			}
			//check leap year and feb
			if(prevM ==2) {
				if((year % 4 == 0 && year % 100 != 0) || year % 400 == 0){
					prevD = 29;
				}else {
					prevD = 28;
				}
			}else if (month == 4 || month == 6 || month == 9 || month == 11) {
				prevD = 30;
			}else {
				prevD = 31;
			}
		}
		return new Date(prevD,prevM,prevY);
	}
	
	public String format(String formatSpecifier) {
		switch(formatSpecifier) {
		case "dd|mm|yyyy/":
			
		}
	}
	
	@Override
	public String toString() {
		return day + "/" + month + "/" + year;
	}
	
}
