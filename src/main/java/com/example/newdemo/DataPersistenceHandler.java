// package com.example.newdemo;

//@Configuration
// public class DataPersistenceHandler {
//     private void dumpMongoDB() {
//         // ensure directories are ok
//         File tempDirectory = new File(mongodbDumpLocation);
//         tempDirectory.delete();
//         tempDirectory.mkdir();
//         try {
//             mongoDBDumper.start();
//         } catch (IOException e) {
//             e.printStackTrace();
//         }
//     }

//     private void restoreMongoDB() {
//         try {
//             mongoDBRestorer.start();
//         } catch (IOException e) {
//             e.printStackTrace();
//         }
//     }

//     @Bean
//     public MongoDumpExecutable mongoDBDumper(IMongodConfig mongodConfig) throws IOException {
//         int port = mongodConfig.net().getPort();
//         IMongoDumpConfig mongoDumpConfig = new MongoDumpConfigBuilder()
//                 .version(Version.Main.PRODUCTION)
//                 .net(new Net(port, Network.localhostIsIPv6()))
//                 .out(mongodbDumpLocation)
//                 .build();

//         return MongoDumpStarter.getDefaultInstance().prepare(mongoDumpConfig);
//     }

//     @Bean
//     public MongoRestoreExecutable mongoDbrestorer(IMongodConfig mongodConfig) throws IOException {
//         int port = mongodConfig.net().getPort();
//         IMongoRestoreConfig mongoRestoreConfig = new MongoRestoreConfigBuilder()
//                 .version(Version.Main.PRODUCTION)
//                 .net(new Net(port, Network.localhostIsIPv6()))
//                 .dropCollection(true)
//                 .dir(mongodbDumpLocation)
//                 .build();

//         return MongoRestoreStarter.getDefaultInstance().prepare(mongoRestoreConfig);
//     }
// }
