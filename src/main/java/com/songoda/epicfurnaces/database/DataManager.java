package com.songoda.epicfurnaces.database;

import com.songoda.core.database.DatabaseConnector;
import org.bukkit.plugin.Plugin;

public class DataManager {


    public DataManager(DatabaseConnector connector, Plugin plugin) {
        //super(connector, plugin);

        // Updating furnaces every 3 minutes should be plenty I believe

    }




//    public void getFurnaces(Consumer<Map<Integer, Furnace>> callback) {
//        this.runAsync(() -> {
//            try (Connection connection = this.databaseConnector.getConnection()) {
//                Map<Integer, Furnace> furnaces = new HashMap<>();
//
//                try (Statement statement = connection.createStatement()) {
//                    String selectFurnaces = "SELECT * FROM " + this.getTablePrefix() + "active_furnaces";
//                    ResultSet result = statement.executeQuery(selectFurnaces);
//                    while (result.next()) {
//                        World world = Bukkit.getWorld(result.getString("world"));
//
//                        if (world == null) {
//                            continue;
//                        }
//
//                        int id = result.getInt("id");
//                        int level = result.getInt("level");
//                        int uses = result.getInt("uses");
//
//                        String placedByStr = result.getString("placed_by");
//                        UUID placedBy = placedByStr == null ? null : UUID.fromString(result.getString("placed_by"));
//
//                        String nickname = result.getString("nickname");
//
//                        int x = result.getInt("x");
//                        int y = result.getInt("y");
//                        int z = result.getInt("z");
//                        Location location = new Location(world, x, y, z);
//
//                        Furnace furnace = new FurnaceBuilder(location)
//                                .setId(id)
//                                .setLevel(EpicFurnaces.getInstance().getLevelManager().getLevel(level))
//                                .setUses(uses)
//                                .setPlacedBy(placedBy)
//                                .setNickname(nickname)
//                                .build();
//
//                        furnaces.put(id, furnace);
//                    }
//                }
//
//                try (Statement statement = connection.createStatement()) {
//                    String selectAccessList = "SELECT * FROM " + this.getTablePrefix() + "access_list";
//                    ResultSet result = statement.executeQuery(selectAccessList);
//                    while (result.next()) {
//                        int id = result.getInt("furnace_id");
//                        UUID uuid = UUID.fromString(result.getString("uuid"));
//
//                        Furnace furnace = furnaces.get(id);
//                        if (furnace == null) {
//                            break;
//                        }
//
//                        furnace.addToAccessList(uuid);
//                    }
//                }
//
//                try (Statement statement = connection.createStatement()) {
//                    String selectLevelupItems = "SELECT * FROM " + this.getTablePrefix() + "to_level_new";
//                    ResultSet result = statement.executeQuery(selectLevelupItems);
//                    while (result.next()) {
//                        int id = result.getInt("furnace_id");
//                        XMaterial material = CompatibleMaterial.getMaterial(result.getString("item")).get();
//                        int amount = result.getInt("amount");
//
//                        Furnace furnace = furnaces.get(id);
//                        if (furnace == null) {
//                            break;
//                        }
//
//                        furnace.addToLevel(material, amount);
//                    }
//                }
//                this.sync(() -> callback.accept(furnaces));
//            } catch (Exception ex) {
//                ex.printStackTrace();
//            }
//        });
//    }
}
