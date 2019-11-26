/**  
* LocalDate常用工具类  
* @author lc  
* @date 2019年10月26日  
*/
public class LocalDateUtils {
	/*
	 * LocalDateTime格式化输出为字符串
	 */
	public static String localDateTime2Str(LocalDateTime ldt, String pattern) {
		return ldt.format(DateTimeFormatter.ofPattern(pattern));
	}

	/*
	 * 格式化字符串转LocalDateTime对象
	 */
	public static LocalDateTime str2LocalDateTime(String timeStr, String pattern) {
		return LocalDateTime.parse(timeStr, DateTimeFormatter.ofPattern(pattern));
	}

	/*
	 * LocalDateTime转时间戳 毫秒数
	 */
	public static Long localDateTime2Timestamp(LocalDateTime ldt) {
		return ldt.toInstant(ZoneOffset.of("+8")).toEpochMilli();
	}

	/*
	 * 时间戳 转LocalDateTime
	 */
	public static LocalDateTime timestamp2LocalDateTime(Long timestamp) {
		return Instant.ofEpochMilli(timestamp).atZone(ZoneId.systemDefault()).toLocalDateTime();
	}

	/*
	 * LocalDate格式化输出为字符串
	 *  默认tostring的格式 就是 yyyy-MM-dd 所以这样格式不需要用这个函数
	 */
	public static String localDate2Str(LocalDate ld, String pattern) {
		return ld.format(DateTimeFormatter.ofPattern(pattern));
	}

	/*
	 * 格式化字符串转LocalDate对象
	 */
	public static LocalDate str2LocalDate(String timeStr, String pattern) {
		return LocalDate.parse(timeStr, DateTimeFormatter.ofPattern(pattern));
	}

	/*
	 * LocalDate转时间戳 毫秒数
	 */
	public static Long localDate2Timestamp(LocalDate ld) {
		return ld.atStartOfDay(ZoneId.systemDefault()).toInstant().toEpochMilli();
	}

	/*
	 * 时间戳 转LocalDate
	 */
	public static LocalDate timestamp2LocalDate(Long timestamp) {
		return Instant.ofEpochMilli(timestamp).atZone(ZoneId.systemDefault()).toLocalDate();
	}

	/*
	 * LocalDate 转 LocalDateTime
	 */
	public static LocalDateTime localDate2LocalDateTime(LocalDate ld) {
		return timestamp2LocalDateTime(localDate2Timestamp(ld));
	}

	/*
	 * LocalDateTime 转 LocalDate
	 */
	public static LocalDate localDateTime2LocalDate(LocalDateTime ldt) {
		return timestamp2LocalDate(localDateTime2Timestamp(ldt));
	}
    
	/*
	  *  计算两个LocalDate相差的天数 
	 */
	 public static Long localDatedDistance(LocalDate ld1,LocalDate ld2) {
		 return  ld2.toEpochDay() - ld1.toEpochDay();
	 }
	 /*
	   *   获取 LocalDate  n天后的日期
	 */
	 public static LocalDate localDatedAddDay(LocalDate ld,long num) {
		 return ld.plusDays(num);
	 }
}