package myapp_restaurante_model.gui_menu.table_custom;

/**
 *
 * @author RAVEN
 */
public interface TableActionEvent {

    public void onEdit(int row);

    public void onDelete(int row);

    public void onView(int row);
}
