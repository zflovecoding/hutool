package cn.hutool.db.ds.simple;

import cn.hutool.db.ds.AbstractDSFactory;
import cn.hutool.setting.Setting;

import javax.sql.DataSource;

/**
 * 简单数据源工厂类
 *
 * @author Looly
 *
 */
public class SimpleDSFactory extends AbstractDSFactory {
	private static final long serialVersionUID = 4738029988261034743L;

	/**
	 * 数据源名称：Hutool-Simple-DataSource
	 */
	public static final String DS_NAME = "Hutool-Simple-DataSource";

	/**
	 * 构造，使用默认配置文件
	 */
	public SimpleDSFactory() {
		this(null);
	}

	/**
	 * 构造，使用自定义配置文件
	 *
	 * @param setting 配置
	 */
	public SimpleDSFactory(final Setting setting) {
		super(DS_NAME, SimpleDataSource.class, setting);
	}

	@Override
	protected DataSource createDataSource(final String jdbcUrl, final String driver, final String user, final String pass, final Setting poolSetting) {
		final SimpleDataSource ds = new SimpleDataSource(//
				jdbcUrl, //
				user, //
				pass, //
				driver//
		);
		ds.setConnProps(poolSetting.getProps(Setting.DEFAULT_GROUP));
		return ds;
	}
}
