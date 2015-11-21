package de.MiningPickaxe.core;

import java.util.Random;

import javax.print.attribute.standard.PrinterLocation;

import net.minecraft.block.Block;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenMinable;
import cpw.mods.fml.common.IWorldGenerator;
import de.MiningPickaxe.structures.StructureDungeon1;

public class WorldGenerationHandler implements IWorldGenerator {

	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world, IChunkProvider chunkGenerator, IChunkProvider chunkProvider) {
		switch(world.provider.dimensionId) {
		case 0 :
			//Generate our surface world
			generateSurface(world, random, chunkX*16, chunkZ*16);
			
		case -1 :
			//Generate our surface world
			generateNether(world, random, chunkX*16, chunkZ*16);
			
		case 1 :
			//Generate our surface world
			generateEnd(world, random, chunkX*16, chunkZ*16);
			
		case 257 :
			generateBattle(world, random, chunkX*16, chunkZ*16);
		}
		
	}

	private void generateSurface(World world, Random random, int x, int z) {
		
		
	}
	
	private void generateNether(World world, Random random, int x, int z) {
		
	}
	
	private void generateEnd(World world, Random random, int x, int z) {
		// TODO Auto-generated method stub
		
	}
	
	private void generateBattle(World world, Random random, int x, int z){
		
		BiomeGenBase biome = world.getWorldChunkManager().getBiomeGenAt(x, z);
		
		if ((biome == BiomeGenBase.desert)) {
			for (int a = 0; a < 1; a++) {
				int i = x + random.nextInt(256);
				int j = z + random.nextInt(256);
				int k = world.getHeightValue(i, j);
				new StructureDungeon1().generate(world, random, i, j, k);
				System.out.println("Generiert");
			}
		}
		
	}

}