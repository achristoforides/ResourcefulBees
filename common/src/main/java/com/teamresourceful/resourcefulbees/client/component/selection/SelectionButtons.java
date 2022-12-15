package com.teamresourceful.resourcefulbees.client.component.selection;

import com.teamresourceful.resourcefulbees.client.component.SlotButton;
import com.teamresourceful.resourcefulbees.client.screen.beepedia.BeepediaScreen;
import com.teamresourceful.resourcefulbees.client.screen.beepedia.state.BeepediaState;
import com.teamresourceful.resourcefullib.client.components.ParentWidget;
import net.minecraft.network.chat.Component;

import java.util.List;

public class SelectionButtons extends ParentWidget {

    private final BeepediaScreen screen;

    public SelectionButtons(int x, int y, BeepediaScreen screen) {
        super(x, y);
        this.screen = screen;
        init();
    }

    @Override
    protected void init() {
        addRenderableWidget(createButton(x, y, BeepediaState.Type.BEES)).setTooltipProvider(() -> List.of(Component.literal("Bees")));
        addRenderableWidget(createButton(x + 22, y, BeepediaState.Type.TRAITS)).setTooltipProvider(() -> List.of(Component.literal("Traits")));
        addRenderableWidget(createButton(x + 44, y, BeepediaState.Type.HONEY)).setTooltipProvider(() -> List.of(Component.literal("Honey")));
    }

    private SlotButton createButton(int x, int y, BeepediaState.Type type) {
        return new SlotButton(x + 28, y, type.texture, () -> this.screen.getState().getType().equals(type), () -> {
            this.screen.getState().setType(type);
            screen.updateSelections();
        });
    }
}
