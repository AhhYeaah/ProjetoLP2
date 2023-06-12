package com.example.demo.utils;

import java.util.HashMap;
import java.util.Map;

import com.example.demo.Enums.Region;

public class EstadoRegiao {
	private static Map<String, Region> estadoRegiaoMap;

	static {
		estadoRegiaoMap = new HashMap();
		estadoRegiaoMap.put("rondônia", Region.NORTE);
		estadoRegiaoMap.put("alagoas", Region.NORDESTE);
		estadoRegiaoMap.put("tocantins", Region.NORTE);
		estadoRegiaoMap.put("amazonas", Region.NORTE);
		estadoRegiaoMap.put("distrito federal", Region.CENTRO_OESTE);
		estadoRegiaoMap.put("piauí", Region.NORDESTE);
		estadoRegiaoMap.put("bahia", Region.NORDESTE);
		estadoRegiaoMap.put("espírito santo", Region.SUDESTE);
		estadoRegiaoMap.put("pará", Region.NORTE);
		estadoRegiaoMap.put("santa catarina", Region.SUL);
		estadoRegiaoMap.put("pernambuco", Region.NORDESTE);
		estadoRegiaoMap.put("minas gerais", Region.SUDESTE);
		estadoRegiaoMap.put("sergipe", Region.NORDESTE);
		estadoRegiaoMap.put("acre", Region.NORTE);
		estadoRegiaoMap.put("amapá", Region.NORTE);
		estadoRegiaoMap.put("paraná", Region.SUL);
		estadoRegiaoMap.put("são paulo", Region.SUDESTE);
		estadoRegiaoMap.put("roraima", Region.NORTE);
		estadoRegiaoMap.put("goiás", Region.CENTRO_OESTE);
		estadoRegiaoMap.put("rio grande do sul", Region.SUL);
		estadoRegiaoMap.put("rio grande do norte", Region.NORDESTE);
		estadoRegiaoMap.put("mato grosso", Region.CENTRO_OESTE);
		estadoRegiaoMap.put("mato grosso do sul", Region.CENTRO_OESTE);
		estadoRegiaoMap.put("maranhão", Region.NORDESTE);
		estadoRegiaoMap.put("paraíba", Region.NORDESTE);
		estadoRegiaoMap.put("ceará", Region.NORDESTE);
		estadoRegiaoMap.put("rio de janeiro", Region.SUDESTE);
	}

	public static Region getRegionByState(String estado) {
		return estadoRegiaoMap.get(estado);
	}
}
