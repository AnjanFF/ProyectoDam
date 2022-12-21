package Modelo;

import java.io.CharArrayReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.io.Serializable;
import java.sql.Clob;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.TimeZone;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRField;
import net.sf.jasperreports.engine.JRResultSetDataSource;
import net.sf.jasperreports.engine.JasperReportsContext;

public class DataSource extends JRResultSetDataSource implements Serializable{

	public DataSource(JasperReportsContext jasperReportsContext, ResultSet resultSet) {
		super(jasperReportsContext, resultSet);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected String clobToString(Clob arg0) throws JRException {
		// TODO Auto-generated method stub
		return super.clobToString(arg0);
	}

	@Override
	protected Calendar createFieldCalendar(JRField arg0) {
		// TODO Auto-generated method stub
		return super.createFieldCalendar(arg0);
	}

	@Override
	protected CharArrayReader getArrayReader(Reader arg0, long arg1) throws IOException {
		// TODO Auto-generated method stub
		return super.getArrayReader(arg0, arg1);
	}

	@Override
	protected Calendar getFieldCalendar(JRField field) {
		// TODO Auto-generated method stub
		return super.getFieldCalendar(field);
	}

	@Override
	public Object getFieldValue(JRField arg0) throws JRException {
		// TODO Auto-generated method stub
		return super.getFieldValue(arg0);
	}

	@Override
	public boolean next() throws JRException {
		// TODO Auto-generated method stub
		return super.next();
	}

	@Override
	protected byte[] readBytes(InputStream is, long size) throws IOException {
		// TODO Auto-generated method stub
		return super.readBytes(is, size);
	}

	@Override
	protected byte[] readBytes(Integer arg0) throws SQLException, IOException {
		// TODO Auto-generated method stub
		return super.readBytes(arg0);
	}

	@Override
	protected Object readDate(Integer columnIndex, JRField field) throws SQLException {
		// TODO Auto-generated method stub
		return super.readDate(columnIndex, field);
	}

	@Override
	protected Object readTime(Integer columnIndex, JRField field) throws SQLException {
		// TODO Auto-generated method stub
		return super.readTime(columnIndex, field);
	}

	@Override
	protected Object readTimestamp(Integer columnIndex, JRField field) throws SQLException {
		// TODO Auto-generated method stub
		return super.readTimestamp(columnIndex, field);
	}

	@Override
	protected TimeZone resolveTimeZone(String arg0) {
		// TODO Auto-generated method stub
		return super.resolveTimeZone(arg0);
	}

	@Override
	protected Integer searchColumnByIndex(JRField arg0) throws SQLException, JRException {
		// TODO Auto-generated method stub
		return super.searchColumnByIndex(arg0);
	}

	@Override
	protected Integer searchColumnByIndex(String index) throws SQLException, JRException {
		// TODO Auto-generated method stub
		return super.searchColumnByIndex(index);
	}

	@Override
	protected Integer searchColumnByLabel(JRField arg0) throws SQLException, JRException {
		// TODO Auto-generated method stub
		return super.searchColumnByLabel(arg0);
	}

	@Override
	protected Integer searchColumnByLabel(String arg0) throws SQLException {
		// TODO Auto-generated method stub
		return super.searchColumnByLabel(arg0);
	}

	@Override
	protected Integer searchColumnByName(JRField arg0) throws SQLException, JRException {
		// TODO Auto-generated method stub
		return super.searchColumnByName(arg0);
	}

	@Override
	protected Integer searchColumnByName(String arg0) throws SQLException {
		// TODO Auto-generated method stub
		return super.searchColumnByName(arg0);
	}

	@Override
	public void setReportTimeZone(TimeZone reportTimeZone) {
		// TODO Auto-generated method stub
		super.setReportTimeZone(reportTimeZone);
	}

	@Override
	public void setTimeZone(TimeZone timeZone, boolean override) {
		// TODO Auto-generated method stub
		super.setTimeZone(timeZone, override);
	}

	
}
