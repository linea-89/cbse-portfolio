

module core {

    requires common;
    requires gdx.backend.lwjgl;
    requires java.desktop;
    requires gdx;

    //requires com.badlogicgames.gdx;




    uses dk.sdu.mmmi.cbse.common.services.IGamePluginService;
    uses dk.sdu.mmmi.cbse.common.services.IEntityProcessingService;
    uses dk.sdu.mmmi.cbse.common.services.IPostEntityProcessingService;

}