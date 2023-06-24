package com.example.demo.resource;

import lombok.Data;
import java.math.BigDecimal;
import javax.persistence.*;

@Data
@Entity
public class Product {
	
	@Id
	private long Id;
	private String Name;
	private String Description;
	private BigDecimal Price;
	

}
