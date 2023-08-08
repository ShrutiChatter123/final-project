package com.xworkz.parking.entity;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import com.xworkz.parking.constants.ParkingConstants;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Setter
@Getter
@AllArgsConstructor
@EqualsAndHashCode
@ToString
@NoArgsConstructor
@Table(name = "userinfotable")
@NamedQuery(name = "findByMail", query = "select aa from UserinfoEntity as aa where aa.email=:mail")
@NamedQuery(name = "updateOTP", query = "update UserinfoEntity entity set entity.emailOTP=:onetimeotp where entity.email=:sendmail")
public class UserinfoEntity extends ParkingConstants {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int userId;

	private String name;

	private String email;

	private long mobile;

	private static final long OTP_VALID_DURATION = 5 * 60 * 1000;

	private String emailOTP;

	private Date otpRequestedTime;

	public boolean isOtpRequired() {
		if (this.getEmailOTP() == null) {
			return false;
		}
		long currentTimeMillis = System.currentTimeMillis();
		long otpRequestedTimeInMillis = this.getOtpRequestedTime().getTime();

		if (otpRequestedTimeInMillis + OTP_VALID_DURATION < currentTimeMillis)
//	otp expired message will accure to this point
			return false;
		return true;

	}

}
