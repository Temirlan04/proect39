package kg.geektech.proectandroid39.ui.films;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import kg.geektech.proectandroid39.common.OnItemClick;
import kg.geektech.proectandroid39.data.models.Film;
import kg.geektech.proectandroid39.databinding.ItemFilmBinding;

public class FilmsAdapter extends RecyclerView.Adapter<FilmsAdapter.FilmsViewHolder> {

    private List<Film> films = new ArrayList<>();
    private OnItemClick<String> listener;



    public void setListener(OnItemClick<String> listener) {
        this.listener = listener;
    }

    public void setFilms(List<Film> films) {
        this.films = films;
        notifyDataSetChanged();
    }
    @NonNull
    @Override
    public FilmsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       ItemFilmBinding binding = ItemFilmBinding.inflate(
               LayoutInflater.from(parent.getContext()),
               parent,
               false
       );
        return new FilmsViewHolder(binding);

    }

    @Override
    public void onBindViewHolder(@NonNull FilmsViewHolder holder, int position) {
        holder.onBind(films.get(position));
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.onItemClick(films.get(holder.getAdapterPosition()).getId(), holder.getAdapterPosition());

            }
        });
    }

    @Override
    public int getItemCount() {
        return films.size();
    }

    protected class FilmsViewHolder extends  RecyclerView.ViewHolder{
        private ItemFilmBinding binding;
        public FilmsViewHolder(@NonNull ItemFilmBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        public void onBind(Film film) {

            binding.tvTitle.setText(film.getTitle());
            binding.tvDescription.setText(film.getDescription());
        }
    }
}
