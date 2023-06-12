package com.example.demo.BoundingBoxes;

import com.example.demo.Enums.ClientTypeEnum;
import com.example.demo.utils.Cordinates;

public class ClientType {

	public static ClientTypeEnum getClientType(Cordinates cords) {
		if (new SpecialBoundingBox1().isInsideMe(cords) || new SpecialBoundingBox2().isInsideMe(cords)) {
			return ClientTypeEnum.SPECIAL;
		}

		if (new NormalBoundingBox().isInsideMe(cords)) {
			return ClientTypeEnum.NORMAL;
		}

		return ClientTypeEnum.LABORIOUS;
	}
}
