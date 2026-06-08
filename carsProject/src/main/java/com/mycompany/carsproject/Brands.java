/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.carsproject;

import java.time.LocalDate;
import java.util.Scanner;
import java.util.ArrayList;

/**
 *
 * @author MelanieViToM
 */
public class Brands {
   private int brandId;
   private String brandCode;
   private String brandName;
   private String brandAbbrev;
   private int brandCityId;
   private String brandDescription;
   private boolean brandStatus;
   private LocalDate brandCreatedAt;
   private LocalDate brandUpdatedAt;
   
   private static ArrayList<Brands> brandsList = new ArrayList<>();
   private static int nextId = 1;
   
   //Empty constructor
   public Brands(){ }
   
   public Brands(int brandId, String brandCode, String brandName, String brandAbbrev, int brandCityId, String brandDescription,
           boolean brandStatus, LocalDate brandCreatedAt, LocalDate brandUpdatedAt){
       this.brandId = brandId;
       this.brandCode = brandCode;
       this.brandName = brandName;
       this.brandAbbrev = brandAbbrev;
       this.brandCityId = brandCityId;
       this.brandDescription = brandDescription;
       this.brandStatus = brandStatus;
       this.brandCreatedAt = brandCreatedAt;
       this.brandUpdatedAt = brandUpdatedAt;
    }
   
    //Getters and Setters
    public int getBrandId() {
        return brandId;
    }
    public void setBrandId(int brandId){
        this.brandId = brandId;
    }
    
    public String getBrandCode() {
        return brandCode;
    }
    public void setBrandCode(String brandCode){
        this.brandCode = brandCode;
    }
    
    public String getBrandName() {
        return brandName;
    }
    public void setBrandName(String brandName){
        this.brandName = brandName;
    }

    public String getBrandAbbrev() {
        return brandAbbrev;
    }
    public void setBrandAbbrev(String brandAbbrev){
        this.brandAbbrev = brandAbbrev;
    }
    public int getBrandCityId() {
        return brandCityId;
    }
    public void setBrandCityId(int brandCityId){
        this.brandCityId = brandCityId;
    }
    public String getBrandDescription() {
        return brandDescription;
    }
    public void setBrandDescription(String brandDescription){
        this.brandDescription = brandDescription;
    }
    public boolean getBrandStatus() {
        return brandStatus;
    }
    public void setBrandStatus(boolean brandStatus){
        this.brandStatus = brandStatus;
    }
    public LocalDate getBrandCreatedAt() {
        return brandCreatedAt;
    }
    public void setBrandCreatedAt(LocalDate brandCreatedAt){
        this.brandCreatedAt = brandCreatedAt;
    }
    public LocalDate getBrandUpdatedAt() {
        return brandUpdatedAt;
    }
    public void setBrandUpdatedAt(LocalDate brandUpdatedAt){
        this.brandUpdatedAt = brandUpdatedAt;
    }
    
    public static void registerBrand(Scanner entrance) {
        System.out.println("\n::: REGISTER NEW BRAND :::");
        System.out.print("  Code        : "); String brand_code = entrance.nextLine().trim();
        
        boolean codeExists = brandsList.stream().anyMatch(brand -> brand.getBrandCode().equalsIgnoreCase(brand_code));
        String finalCode = brand_code;
        while (codeExists) {
            System.out.println("  [✗] Code already exists. Please enter a unique code.");
            System.out.print("  Code        : ");
            finalCode = entrance.nextLine().trim();

            String temp = finalCode;
            codeExists = brandsList.stream().anyMatch(brand -> brand.getBrandCode().equalsIgnoreCase(temp));
        }

        System.out.print("  Name        : "); String brand_name   = entrance.nextLine().trim();
        System.out.print("  Abbreviation: "); String brand_abbrev = entrance.nextLine().trim();
        System.out.print("  City ID     : "); int brand_city_id    = Integer.parseInt(entrance.nextLine().trim());
        System.out.print("  Description : "); String brand_description   = entrance.nextLine().trim();

        brandsList.add(new Brands(nextId++, finalCode, brand_name, brand_abbrev, brand_city_id, brand_description,
                                  true, LocalDate.now(), LocalDate.now()));
        System.out.println("Brand registered with Id: " + (nextId - 1));
    }
    
    public static void listBrands() {
    System.out.println("\n::: BRANDS LIST :::");
    if (brandsList.isEmpty()) { System.out.println("Without registers"); return; }
    for (Brands b : brandsList) {
        System.out.printf("  [%d] Code: %s | Name: %s | Abbreviation: %s | City Id: %d | Description: %s | Status: %s%n",
                b.getBrandId(),b.getBrandCode(), b.getBrandName(), b.getBrandAbbrev(),
                b.getBrandCityId(), b.getBrandDescription(),
                b.getBrandStatus() ? "Active" : "Inactive");
        }
    }
    
    public static void searchBrand(Scanner entrance) {
        System.out.println("\n::: SEARCH BRAND :::");
        System.out.print("Code: "); String q = entrance.nextLine().trim();
        for (Brands b : brandsList) {
            if (b.getBrandCode().equalsIgnoreCase(q)) {
                System.out.printf("Id: %d | Code: %s | Name: %s | Abbreviation: %s | City Id:%d | Description: %s | Status:%s%n",
                    b.getBrandId(), b.getBrandCode(), b.getBrandName(), b.getBrandAbbrev(),
                    b.getBrandCityId(), b.getBrandDescription(),
                    b.getBrandStatus() ? "Active" : "Inactive");
                return;
            }
        }
        System.out.println("  [!] Not found: " + q);
    }

    public static boolean abbrevExists(String abbrev, int currentId) {
        for (Brands b : brandsList) {
            if (b.getBrandAbbrev().equalsIgnoreCase(abbrev)
                    && b.getBrandId() != currentId) {
                return true;
            }
        }
        return false;
    }
    
    public static void updateBrand(Scanner entrance) {
        System.out.println("\n::: UPDATE BRAND :::");
        
        Brands t = null;
        while (true) {
            System.out.print("  Code to find: ");
            String query = entrance.nextLine().trim();
            for (Brands b : brandsList) {
                if (b.getBrandCode().equalsIgnoreCase(query)) {
                    t = b;
                    break;
                }
            }
            if (t != null) break;
            System.out.println("  [!] Code not found. Try again.");
        }

        System.out.println("Enter to keep current value");

        // ── Actualiza los demás campos, NO el Code ────────────────────────────
        System.out.print("  Name [" + t.getBrandName() + "]: ");
        String name = entrance.nextLine().trim();
        if (!name.isEmpty()) t.setBrandName(name);

        System.out.print("  Abbreviation [" + t.getBrandAbbrev() + "]: ");
        String abbrev = entrance.nextLine().trim();
        if (!abbrev.isEmpty()) {
            if (abbrevExists(abbrev, t.getBrandId()))
                System.out.println("  [!] Abbreviation duplicated, not updated.");
            else
                t.setBrandAbbrev(abbrev);
        }

        System.out.print("  City Id [" + t.getBrandCityId() + "]: ");
        String city = entrance.nextLine().trim();
        if (!city.isEmpty()) t.setBrandCityId(Integer.parseInt(city));

        System.out.print("  Description [" + t.getBrandDescription() + "]: ");
        String desc = entrance.nextLine().trim();
        if (!desc.isEmpty()) t.setBrandDescription(desc);

        System.out.print("  Status true/false [" + t.getBrandStatus() + "]: ");
        String status = entrance.nextLine().trim();
        if (!status.isEmpty()) t.setBrandStatus(Boolean.parseBoolean(status));

        t.setBrandUpdatedAt(LocalDate.now());
        System.out.println("Brand '" + t.getBrandCode() + "' uptades!");
    }
    
    public static void deleteBrand(Scanner entrance) {
        System.out.println("\n::: DELETE BRAND :::");

        // ── Busca por Code ────────────────────────────────────────────────────
        Brands t = null;
        while (true) {
            System.out.print("  Code to delete: ");
            String query = entrance.nextLine().trim();
            for (Brands b : brandsList) {
                if (b.getBrandCode().equalsIgnoreCase(query)) {
                    t = b;
                    break;
                }
            }
            if (t != null) break;
            System.out.println("Code not found. Try again.");
        }

        System.out.println("  Brand to delete: [" + t.getBrandId() + "]" + "| Code: " + t.getBrandCode()+ " | Name: " +t.getBrandName());
        System.out.print("  Confirm elimination (yes/no): ");

        if (entrance.nextLine().trim().equalsIgnoreCase("yes")) {
            brandsList.remove(t);
            System.out.println(" Brand '" + t.getBrandCode() + "' deleted.");
        } else {
            System.out.println(" [i] Canceled.");
        }
    }
}
