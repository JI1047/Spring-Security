# 🔐 Spring Security Login System

## 📖 프로젝트 소개
Spring Security를 사용하여 간단한 로그인 및 권한 관리를 구현

## ⚙️ 기술 스택
- **Backend**: Spring Boot, Spring Security
- **Database**:  MySQL
- **Authentication**: BCrypt Password Encoding, Session-based Authentication

## 🚀 기능
- 회원 가입 & 로그인 (비밀번호 암호화)
- 권한(Role) 기반 접근 제어
- 관리자 페이지 접근 제한
- 다중 로그인 제한 (한 계정당 1개 세션 유지)
- 세션 고정 공격 방어

## 🏗️ 프로젝트 구조
📂 testsecurity
┣ 📂 config (보안 설정)
┃ ┗ 📄 SecurityConfig.java
┣ 📂 controller (API 컨트롤러)
┃ ┣ 📄 LoginController.java
┃ ┣ 📄 JoinController.java
┃ ┗ 📄 AdminController.java
┣ 📂 entity (데이터 모델)
┃ ┗ 📄 User.java
┣ 📂 repository (DB 접근 레이어)
┃ ┗ 📄 UserRepository.java
┣ 📂 service (비즈니스 로직)
┃ ┣ 📄 CustomUserDetailService.java
┃ ┗ 📄 JoinService.java
┗ 📄 TestSecurityApplication.java


📝 학습한 내용 정리
- Spring Security를 사용하여 로그인 및 권한 관리 구현
- BCrypt로 비밀번호 해싱 적용
- 세션 관리 & 보안 기능 설정 (다중 로그인 제한, 세션 고정 공격 방지)
- **Spring Security의 SecurityFilterChain**을 활용한 커스텀 보안 설정
