package team.adyn.bean;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.hadoop.io.Writable;
import org.apache.hadoop.io.WritableComparable;
import org.apache.hadoop.mapreduce.lib.db.DBWritable;

public class MNum implements Writable, WritableComparable<MNum>, DBWritable {

	private Integer mid;
	private String countinfo;
	private int mcount;

	public Integer getMid() {
		return mid;
	}

	public void setMid(Integer mid) {
		this.mid = mid;
	}

	public String getCountinfo() {
		return countinfo;
	}

	public void setCountinfo(String countinfo) {
		this.countinfo = countinfo;
	}

	public int getMcount() {
		return mcount;
	}

	public void setMcount(int mcount) {
		this.mcount = mcount;
	}

	public MNum(Integer mid, String countinfo, int mcount) {
		super();
		this.mid = mid;
		this.countinfo = countinfo;
		this.mcount = mcount;
	}

	public MNum() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "MNum [mid=" + mid + ", countinfo=" + countinfo + ", mcount=" + mcount + "]";
	}

	public int compareTo(MNum m) {
		// TODO Auto-generated method stub
		return this.mid - m.mid;
	}

	public void write(PreparedStatement st) throws SQLException {
		// TODO Auto-generated method stub
		st.setInt(1, mid);
		st.setString(2, countinfo);
		st.setInt(3, mcount);
	}

	public void readFields(ResultSet re) throws SQLException {
		// TODO Auto-generated method stub
		this.mid = re.getInt(1);
		this.countinfo = re.getString(2);
		this.mcount = re.getInt(3);
	}

	public void write(DataOutput out) throws IOException {
		// TODO Auto-generated method stub
		out.writeInt(mid);
		out.writeUTF(countinfo);
		out.writeInt(mcount);
	}

	public void readFields(DataInput in) throws IOException {
		// TODO Auto-generated method stub
		this.mid = in.readInt();
		this.countinfo = in.readUTF();
		this.mcount = in.readInt();
	}

}
