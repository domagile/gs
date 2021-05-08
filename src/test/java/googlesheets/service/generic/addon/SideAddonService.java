package googlesheets.service.generic.addon;

import googlesheets.model.generic.SideAddonOptions;

public interface SideAddonService<T extends SideAddonOptions> {
    void selectRange(String range);

    void runAddon();

    void setOptions(T options);

    void execute();
}
