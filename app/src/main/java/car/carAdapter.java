package car;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.vtlallklmc.autobook_btl.R;

import java.io.ByteArrayOutputStream;
import java.util.List;

public class carAdapter extends RecyclerView.Adapter<carAdapter.carViewHolder>{

    private List<car> lstCar; //khai báo ds xe

    public void setData(List<car> lst){ //phương thức thiết lập dữ liệu
        this.lstCar= lst;
        notifyDataSetChanged(); //thông báo dữ liệu đã thay đổi
    }

    @NonNull
    @Override
    public carViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_car, parent, false); //khởi tạo ghép view với layout item_car
        return new carViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull carViewHolder holder, int position) {
        car car = lstCar.get(position);
        if(car == null){
            return;
        }
        Bitmap bitmap = BitmapFactory.decodeFile(String.valueOf(R.drawable.c200_3));
        ByteArrayOutputStream byteArray = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG,100,byteArray);
        byte[] img = byteArray.toByteArray();
//        holder.img_car.setImageResource(car.getImg1()); //lấy id của ảnh item car
        holder.car_name.setText(car.getName()); // lấy tên của item car
    }

    @Override
    public int getItemCount() {
        //kiểm tra rỗng
        if(lstCar != null)
            return lstCar.size();
        return 0;
    }

    public class carViewHolder extends RecyclerView.ViewHolder{
        private ImageView img_car;
        private TextView car_name;

        public carViewHolder(@NonNull View itemView) {
            super(itemView);

            img_car = itemView.findViewById(R.id.img_car); //ánh xạ địa chỉ
            car_name = itemView.findViewById(R.id.car_name); //too
        }
    }
}
