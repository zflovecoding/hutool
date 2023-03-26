package cn.hutool.db.meta;

import cn.hutool.core.collection.SetUtil;
import cn.hutool.core.text.StrUtil;
import cn.hutool.core.text.split.SplitUtil;
import cn.hutool.db.ds.DSUtil;
import org.junit.Assert;
import org.junit.Test;

import javax.sql.DataSource;
import java.util.List;

/**
 * 元数据信息单元测试
 *
 * @author Looly
 *
 */
public class MetaUtilTest {
	final DataSource ds = DSUtil.getDS("test");

	@Test
	public void getTablesTest() {
		final List<String> tables = MetaUtil.getTables(ds);
		Assert.assertEquals("user", tables.get(0));
	}

	@Test
	public void getTableMetaTest() {
		final Table table = MetaUtil.getTableMeta(ds, "user");
		Assert.assertEquals(SetUtil.of("id"), table.getPkNames());
	}

	@Test
	public void getColumnNamesTest() {
		final String[] names = MetaUtil.getColumnNames(ds, "user");
		Assert.assertArrayEquals(SplitUtil.splitToArray("id,name,age,birthday,gender", StrUtil.COMMA), names);
	}

	@Test
	public void getTableIndexInfoTest() {
		final Table table = MetaUtil.getTableMeta(ds, "user_1");
		Assert.assertEquals(table.getIndexInfoList().size(), 2);
	}
}
