package net.atos.sample.do2dto;

import java.util.Date;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class PersonDTO {
	private Long id;
	
	private String name;
	
	/**
	 * ��Ӧ Person.user.age
	 */
	private Integer age;
	
	private String email;
	
	/**
	 * �� DO ������ֶ�����(birthDay)��һ��
	 */
	private Date birth;
	
	/**
	 * �� DO ������ֶ�(birthDay)������չ,dateFormat ����ʽ
	 */
	private String birthDateFormat;
	
	/**
	 * �� DO ������ֶ�(birthDay)������չ,expression ����ʽ
	 */
	private String birthExpressionFormat;

}
