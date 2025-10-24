package com.BrainBoost.BrainBoost.Exceptions.Response;

import java.util.Date;

public record ResponseEntityCustom(Date timeStamp , String message, String details) {}
