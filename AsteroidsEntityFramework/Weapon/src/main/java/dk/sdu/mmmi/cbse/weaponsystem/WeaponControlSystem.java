package dk.sdu.mmmi.cbse.weaponsystem;

//import com.google.auto.service.AutoService;
import dk.sdu.mmmi.cbse.common.data.Entity;
import dk.sdu.mmmi.cbse.common.data.GameData;
import dk.sdu.mmmi.cbse.common.data.World;
import dk.sdu.mmmi.cbse.common.data.entityparts.LifePart;
import dk.sdu.mmmi.cbse.common.data.entityparts.MovingPart;
import dk.sdu.mmmi.cbse.common.data.entityparts.PositionPart;
import dk.sdu.mmmi.cbse.common.data.entityparts.TimerPart;
import dk.sdu.mmmi.cbse.common.services.IEntityProcessingService;
import dk.sdu.mmmi.cbse.common.services.WeaponSPI;

import static java.lang.Math.cos;
import static java.lang.Math.sin;

//@AutoService({WeaponSPI.class, IEntityProcessingService.class, })
public class WeaponControlSystem implements IEntityProcessingService, WeaponSPI {

    @Override
    public void process(GameData gameData, World world) {

        for (Entity weapon : world.getEntities(Weapon.class)) {

            PositionPart positionPart = weapon.getPart(PositionPart.class);
            MovingPart movingPart = weapon.getPart(MovingPart.class);
            TimerPart timerPart = weapon.getPart(TimerPart.class);
            movingPart.setUp(true);
            if (timerPart.getExpiration() < 0) {
                world.removeEntity(weapon);
            }
            timerPart.process(gameData, weapon);
            movingPart.process(gameData, weapon);
            positionPart.process(gameData, weapon);

            setShape(weapon);
        }
    }

    @Override
    public Entity createWeapon(Entity shooter, GameData gameData) {
        PositionPart shooterPos = shooter.getPart(PositionPart.class);

        float x = shooterPos.getX();
        float y = shooterPos.getY();
        float radians = shooterPos.getRadians();
        float dt = gameData.getDelta();
        float speed = 350;

        Entity weapon = new Weapon();
        weapon.setRadius(2);

        float bx = (float) cos(radians) * shooter.getRadius() * weapon.getRadius();
        float by = (float) sin(radians) * shooter.getRadius() * weapon.getRadius();

        weapon.add(new PositionPart(bx + x, by + y, radians));
        weapon.add(new LifePart(1, 69));
        weapon.add(new MovingPart(0, 5000000, speed, 5));
        weapon.add(new TimerPart(1));

        weapon.setShapeX(new float[2]);
        weapon.setShapeY(new float[2]);

        return weapon;
    }

    private void setShape(Entity entity) {
        float[] shapex = entity.getShapeX();
        float[] shapey = entity.getShapeY();
        PositionPart positionPart = entity.getPart(PositionPart.class);
        float x = positionPart.getX();
        float y = positionPart.getY();
        float radians = positionPart.getRadians();

        shapex[0] = x;
        shapey[0] = y;

        shapex[1] = (float) (x + Math.cos(radians - 4 * 3.1415f / 5));
        shapey[1] = (float) (y + Math.sin(radians - 4 * 3.1145f / 5));

        entity.setShapeX(shapex);
        entity.setShapeY(shapey);
    }

}
