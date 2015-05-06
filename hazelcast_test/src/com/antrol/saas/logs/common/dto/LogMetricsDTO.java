package com.antrol.saas.logs.common.dto;

import java.io.Serializable;

/**
 * 
 * <p>功能描述,该部分必须以中文句号结尾。<p>
 *
 * 创建日期 2015年3月15日<br>
 * @author $Author$<br>
 * @version $Revision$ $Date$
 * @since 1.0.0
 */
public class LogMetricsDTO implements Serializable {
    //
    private static final long serialVersionUID = 4761377555911389559L;
    // 租户Key
    private String licenseKey;
    // 日志总量
    private long count;
    // 平均速率
    private double mean;
    // 1秒钟的流速
    private double m1Rate;
    // 5秒中的流速
    private double m5Rate;
    // 15秒的流速
    private double m15Rate;

    public LogMetricsDTO() {
        super();
    }

    public LogMetricsDTO(String licenseKey, long count, double mean, double m1Rate, double m5Rate, double m15Rate) {
        super();
        this.licenseKey = licenseKey;
        this.count = count;
        this.mean = mean;
        this.m1Rate = m1Rate;
        this.m5Rate = m5Rate;
        this.m15Rate = m15Rate;
    }

    public String getLicenseKey() {
        return licenseKey;
    }

    public void setLicenseKey(String licenseKey) {
        this.licenseKey = licenseKey;
    }

    public long getCount() {
        return count;
    }

    public void setCount(long count) {
        this.count = count;
    }

    public double getMean() {
        return mean;
    }

    public void setMean(double mean) {
        this.mean = mean;
    }

    public double getM1Rate() {
        return m1Rate;
    }

    public void setM1Rate(double m1Rate) {
        this.m1Rate = m1Rate;
    }

    public double getM5Rate() {
        return m5Rate;
    }

    public void setM5Rate(double m5Rate) {
        this.m5Rate = m5Rate;
    }

    public double getM15Rate() {
        return m15Rate;
    }

    public void setM15Rate(double m15Rate) {
        this.m15Rate = m15Rate;
    }

    @Override
    public String toString() {
        return "LogMetricsDTO [licenseKey=" + licenseKey + ", count=" + count + ", mean=" + mean + ", m1Rate=" + m1Rate
                + ", m5Rate=" + m5Rate + ", m15Rate=" + m15Rate + "]";
    }
}
