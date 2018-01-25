package com.git.lee.spring.boot.example.datasource;

import com.git.lee.spring.boot.example.model.DataSourceType;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

/**
 *  动态数据源
 * @author LISHUAIWEI
 * @date 2018/1/25 14:28
 */
public class DynamicDataSource extends AbstractRoutingDataSource{
    @Override
    protected Object determineCurrentLookupKey() {
        if (DataSourceHolder.getDataSource() != null) {
            return DataSourceHolder.getDataSource();
        }
        return DataSourceType.MASTER.getType();
    }
}
