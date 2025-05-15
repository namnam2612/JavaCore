package vn.com.t3h.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/*
-danh dau cho spring biet day la tang controller va can duoc tao bean trong spring container
-tra ve giao dien html qua thu vien jsp

- bean trong spring: tat ca cac object thay vi dev phai chu dong tao dong tuong bang tu khoa new
khi su dung cac annotation @component, @service, @controller, @repository
-> spring se tu dong su dung co che IDC de tao ra cac bean va su dung co che DI tiem cac bean vao
trong cac class

@component, @service, @controller, @repository:
    tat ca cac annoation nay ve ban chat khong khac nhau vi deu dung de danh dau giup tao ra bean
    - khi co ten khac nhau se giup phan tach cac tang xu ly logic rieng trong project
    - @Controller -> package controller:
        chi su dung o tang controller, noi tiep nhan cac request, param, va tra ve cac response cho client
    - @Service -> package service:
        chi dinh do la tang xu ly nghiep vu logic cua chuc nang
        tang nay se tiep nhan cac param va request tu controller va goi toi tang repository de thao tac voi du lieu
    - @Repository -> package dao, spring boot -> package repository:
        danh dau dau la tang chuyen thao tac voi du lieu, giao tiep voi cac co so du lieu
        tao ra cac cau query va query vao database de tra ra du lieu cho tang service


    * Cau truc project:
    + package controller:
        chua cac file class controller co cac method tiep nhan request, tra ve response
        package nay se su dung cac class tai package service

    + package service:
        chua cac file class xu ly logic cua chuc nang
        tiep nhan cac request va goi toi cac class package dao de giao tiep voi database

    + package dao | repository
        chua cac file interface hoac class chuyen su dung de giao tiep voi database
        package nay duoc tang service goi toi

    + model | dta (data transfer object)
        chua tat ca cac class model | dta duoc su dung de luu tru du lieu phuc vu qua trinh
        xu ly va truyen tai tai tat ca cac tang controller, service, repository trong object

        vd: du lieu duoc tra ra trong database se duoc class trong package nay tiep nhan va tao
        ra cac doi tuong de cac tang service, controller xu ly
* */
@Controller
public class HomeController {
    /*
    @GetMapping: method get cua http
    @PostMapping: method post cua http
    @PutMapping: method Put http
    @DeleteMapping: method delete http

    /home: -> method nay se duoc xu ly request voi url localhost:8080/home
    */
    @GetMapping("/home")
    public String home() {
        return "home";
    }
}
