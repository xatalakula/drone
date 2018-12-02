package com.example.noname.ttnm12;


import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class NotificationFrag extends Fragment {

    CustomListNoti customListNoti;
    ListView listView;
    private int kind;

    public NotificationFrag() {
        // Required empty public constructor
    }

    @SuppressLint("ValidFragment")
    public NotificationFrag(int kind) {
        this.kind = kind;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_notification, container, false);
        listView = (ListView) view.findViewById(R.id.listview_notification);
        customListNoti = new CustomListNoti(getListData(),getActivity());
        listView.setAdapter(customListNoti);
        return view;
    }

    private List<NotificationObj> getListData() {
        List<NotificationObj> list = new ArrayList<>();

        if(kind == 1) {
            list.add(new NotificationObj("Từ: Cán bộ phụ trách", "Ngày 12/11/2018 - Thời gian: 13:05:06", "Có dấu hiệu khả nghi tại vị trí 13°14'23'' khu vực 2." +
                    "Đề nghị kiểm lâm phụ trách tiến hành kiểm tra ngay và báo cáo lại " +
                    "trước 22:00:00 ngày 30/11/2018."));
            list.add(new NotificationObj("Từ: Cán bộ phụ trách", "Ngày 23/10/2018 - Thời gian: 17:54:54", "Có dấu hiệu khả nghi tại vị trí 15°23'66'' khu vực 4" +
                    "Đề nghị kiểm lâm phụ trách tiến hành kiểm tra ngay và báo cáo lại " +
                    "trước 22:00:00 ngày 30/15/2018."));
            list.add(new NotificationObj("Từ: Cán bộ phụ trách", "Ngày 10/09/2018 - Thời gian: 03:02:14", "Nghi ngờ cán bộ kiểm lâm mã số XYT434 thuộc khu vực A3 không hoàn thành nhiệm vụ " +
                    "ngày 12/11/2018. Đề nghị cán bộ tiến hành giải trình với cán bộ phụ " +
                    "trách trước ngày 15/11/2018."));
            list.add(new NotificationObj("Từ: Hệ thống", "Ngày 22/05/2018 - Thời gian: 12:56:54", "Bắt đầu từ ngày 01/03/2018 các cán bộ kiểm lâm sẽ tiến hành báo cáo công việc hằng ngày " +
                    "trước 10:00:00 mỗi ngày. Thông tin chi tiết về nội dung báo cáo sẽ được gửi " +
                    "cho từng cán bộ kiểm lâm sau."));
        }else {
            list.add(new NotificationObj("Từ :Hệ thống","Ngày 12/11/2018 - Thời gian: 13:05:06","Drone có mã là drone_ggwp_01 đang bị lệch " +
                    "khỏi quỹ đạo bay dự kiến, cần có sự điều khiển bằng tay để trở về đúng quỹ đạo."));
            list.add(new NotificationObj("Từ :Hệ thống","Ngày 10/10/2018 - Thời gian: 15:55:56","Tín hiệu kết của drone có mã drone_ggwp_02 bị mất tại vị trí " +
                    "13°15'43'' tại khu vực 02. Nghi ngờ bị phá hỏng."));
            list.add(new NotificationObj("Từ :Hệ thống","Ngày 23/05/2018 - Thời gian: 02:43:33","Điều kiện thời tiết hiện tại không đủ tiêu chuẩn để hoạt động cho các drone. " +
                    "Yêu cầu cán bộ kiểm lâm không cố gắng khởi động drone để tránh gây ra tổng thất."));
        }


        return list;
    }

}
