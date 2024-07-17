package com.online_housing.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.online_housing.model.Housing;
import com.online_housing.model.Owner;
import com.online_housing.service.HousingService;
import com.online_housing.service.OwnerService;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;

@RestController
@RequestMapping("/api/housings")
public class HousingController {

    @Autowired
    private HousingService housingService;

    @Autowired
    private OwnerService ownerService;

    @Value("${jwt.secret}")
    private String jwtSecret;

    private Long getOwnerIdFromToken(HttpServletRequest request) {
        String token = request.getHeader("Authorization").replace("Bearer ", "");
        Claims claims = Jwts.parser()
                .setSigningKey(jwtSecret)
                .parseClaimsJws(token)
                .getBody();
        return ownerService.getOwnerByUsername(claims.getSubject()).getId();
    }

    @PostMapping("/create")
    public Housing createHousing(@RequestBody Housing housing, HttpServletRequest request) {
        Long ownerId = getOwnerIdFromToken(request);
        Owner owner = ownerService.getOwnerByUsername(ownerService.getOwnerByUsername(ownerId.toString()).getOwnerUserName());
        housing.setOwner(owner);
        return housingService.saveHousing(housing);
    }

    @PutMapping("/update")
    public Housing updateHousing(@RequestBody Housing housing, HttpServletRequest request) {
        Long ownerId = getOwnerIdFromToken(request);
        Owner owner = ownerService.getOwnerByUsername(ownerService.getOwnerByUsername(ownerId.toString()).getOwnerUserName());
        if (housing.getOwner().getId().equals(owner.getId())) {
            return housingService.saveHousing(housing);
        }
        return null; // or handle unauthorized update
    }

    @GetMapping("/my-housings")
    public List<Housing> getMyHousings(HttpServletRequest request,
                                       @RequestParam(defaultValue = "0") int page,
                                       @RequestParam(defaultValue = "10") int size,
                                       @RequestParam Map<String, String> allParams) {
        Long ownerId = getOwnerIdFromToken(request);
        PageRequest.of(page, size);
        // Apply filters from allParams if necessary
        return housingService.getHousingsByOwner(ownerId);
    }

    @GetMapping("/public")
    public List<Housing> getAllHousings(@RequestParam(defaultValue = "0") int page,
                                        @RequestParam(defaultValue = "10") int size,
                                        @RequestParam Map<String, String> allParams) {
        PageRequest.of(page, size);
        // Apply filters from allParams if necessary
        return housingService.getHousingsByOwner(null); // Modify to return all housings
    }
}

