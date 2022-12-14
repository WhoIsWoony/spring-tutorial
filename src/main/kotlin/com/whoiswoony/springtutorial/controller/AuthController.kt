package com.whoiswoony.springtutorial.controller

import com.whoiswoony.springtutorial.dto.LoginRequest
import com.whoiswoony.springtutorial.dto.LoginResponse
import com.whoiswoony.springtutorial.dto.RegisterRequest
import com.whoiswoony.springtutorial.service.member.AuthService
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@Tag(name="유저", description = "유저관련 api 입니다")
@RestController
@RequestMapping("/auth/")
class AuthController(private val authService: AuthService) {
    @Operation(summary = "로그인", description = "로그인입니다.")
    @PostMapping("/login")
    fun login(@RequestBody loginRequest: LoginRequest): LoginResponse {
        return authService.login(loginRequest)
    }

    @Operation(summary = "회원가입", description = "유저를 생성합니다")
    @PostMapping("/register")
    fun register(@RequestBody registerRequest: RegisterRequest){
        return authService.register(registerRequest)
    }
}