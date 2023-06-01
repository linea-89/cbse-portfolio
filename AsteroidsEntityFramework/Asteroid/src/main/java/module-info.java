module asteroid {
    requires common;

    provides dk.sdu.mmmi.cbse.common.services.IEntityProcessingService
            with dk.sdu.mmmi.cbse.asteroid.AsteroidControlSystem, dk.sdu.mmmi.cbse.asteroid.AsteroidSplitter;

    provides dk.sdu.mmmi.cbse.common.services.IGamePluginService
            with dk.sdu.mmmi.cbse.asteroid.AsteroidPlugin;

    provides dk.sdu.mmmi.cbse.common.services.IPostEntityProcessingService
            with dk.sdu.mmmi.cbse.asteroid.AsteroidPlugin;

}