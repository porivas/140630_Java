package date20140812_io_Store;

import java.util.ArrayList;

public interface IFoodStoreDAO {
	public abstract ArrayList LoadData() throws Exception;

	public abstract void SaveData(ArrayList stores) throws Exception;

}
