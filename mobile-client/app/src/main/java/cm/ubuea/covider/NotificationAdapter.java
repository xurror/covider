package cm.ubuea.covider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class NotificationAdapter extends RecyclerView.Adapter<NotificationAdapter.ViewHolder> implements Filterable {

    ArrayList<NotificationModel> notificationModelArrayList, notificationModelArrayListCopy;
    private NotificationAdapter.OnItemClickListener mListener;



    @Override
    public Filter getFilter() {
        return new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence constraint) {
                String charString = constraint.toString();
                if (charString.isEmpty()) {
                    notificationModelArrayListCopy = notificationModelArrayList;
                } else {
                    ArrayList<NotificationModel> filteredList = new ArrayList<>();
                    for (NotificationModel row : notificationModelArrayList) {

                        // name match condition. this might differ depending on your requirement
                        // here we are looking for name or phone number match
                        if (row.getTitle().toLowerCase().contains(charString.toLowerCase()) || row.getNotification().toLowerCase().contains(charString.toLowerCase()) || row.getDate().toLowerCase().contains(charString.toLowerCase()) ) {
                            filteredList.add(row);
                        }
                    }
                    notificationModelArrayListCopy = filteredList;
                }

                FilterResults filterResults = new FilterResults();
                filterResults.values = notificationModelArrayListCopy;
                return filterResults;
            }

            @Override
            protected void publishResults(CharSequence constraint, FilterResults results) {
                notificationModelArrayListCopy = (ArrayList<NotificationModel>) results.values;
                notifyDataSetChanged();
            }
        };
    }


    public interface OnItemClickListener {
        void onItemClick(int position);
    }

    public void setOnItemClickListener(NotificationAdapter.OnItemClickListener listener) {
        mListener = listener;
    }

    public NotificationAdapter(ArrayList<NotificationModel> notificationModelArrayList) {
        this.notificationModelArrayList = notificationModelArrayList;
        this.notificationModelArrayListCopy = notificationModelArrayList;
    }

    @Override
    public NotificationAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_person_notifications_content,parent,false);
        return new NotificationAdapter.ViewHolder(view, (NotificationAdapter.OnItemClickListener) mListener);
    }

    @Override
    public void onBindViewHolder(NotificationAdapter.ViewHolder holder, int position) {

        String ret_head = notificationModelArrayListCopy.get(position).getTitle();
        holder.set_title(ret_head);

        String ret_head0 = notificationModelArrayListCopy.get(position).getNotification();
        holder.set_notification(ret_head0);

        String ret_sub = notificationModelArrayListCopy.get(position).getDate();
        holder.set_date(ret_sub);

    }

    @Override
    public int getItemCount() {
        return notificationModelArrayListCopy.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView title, notification, date;
        View myView;

        public ViewHolder(View itemView, final NotificationAdapter.OnItemClickListener listener) {
            super(itemView);
            myView = itemView;
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (listener != null) {
                        int position = getAdapterPosition();
                        if (position != RecyclerView.NO_POSITION) {
                            listener.onItemClick(position);
                        }
                    }
                }
            });

        }

        public void set_title(String t)
        {
            title = myView.findViewById(R.id.title);
            title.setText(t);
        }

        public void set_notification(String n)
        {
            notification = myView.findViewById(R.id.notification);
            notification.setText(n);
        }

        public void set_date(String d)
        {
            date = myView.findViewById(R.id.date);
            date.setText(d);
        }

    }




}
