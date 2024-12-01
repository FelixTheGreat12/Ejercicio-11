package com.upiiz.securitydatabase;

import com.upiiz.securitydatabase.entites.PermissionEntity;
import com.upiiz.securitydatabase.entites.RoleEntity;
import com.upiiz.securitydatabase.entites.RoleEnum;
import com.upiiz.securitydatabase.entites.UserEntity;
import com.upiiz.securitydatabase.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;
import java.util.Set;

@SpringBootApplication
public class SecuritydatabaseApplication {

	public static void main(String[] args) {
		SpringApplication.run(SecuritydatabaseApplication.class, args);
	}
	@Bean
	CommandLineRunner init(UserRepository userRepository) {
		return args -> {
			// CREAR PERMISOS
			PermissionEntity createPermission = PermissionEntity
					.builder()
					.name("CREATE")
					.build();
			PermissionEntity deletePermission = PermissionEntity
					.builder()
					.name("DELETE")
					.build();
			PermissionEntity updatePermission = PermissionEntity
					.builder()
					.name("UPDATE")
					.build();
			PermissionEntity readPermision = PermissionEntity
					.builder()
					.name("READ")
					.build();
			PermissionEntity deployPermision = PermissionEntity
					.builder()
					.name("DEPLOY")
					.build();
			// Crear ROLES
			RoleEntity adminRole = RoleEntity
					.builder()
					.roleEnum(RoleEnum.ADMIN)
					.permissions(Set.of(createPermission, deletePermission, updatePermission, readPermision))
					.build();
			RoleEntity userRole = RoleEntity
					.builder()
					.roleEnum(RoleEnum.USER)
					.permissions(Set.of(updatePermission, readPermision))
					.build();
			RoleEntity guestRole = RoleEntity
					.builder()
					.roleEnum(RoleEnum.GUEST)
					.permissions(Set.of(readPermision))
					.build();
			RoleEntity developerRole = RoleEntity
					.builder()
					.roleEnum(RoleEnum.DEVELOPER)
					.permissions(Set.of(deployPermision, createPermission, deletePermission, updatePermission, readPermision))
					.build();
			// USUARIOS
			UserEntity juan = UserEntity
					.builder()
					.username("juan")
					.password("1234")
					.isEnabled(true)
					.accountNonExpired(true)
					.credentialNoExpired(true)
					.roles(Set.of(developerRole))
					.build();
			UserEntity jose = UserEntity
					.builder()
					.username("jose")
					.password("1234")
					.isEnabled(true)
					.accountNonExpired(true)
					.credentialNoExpired(true)
					.roles(Set.of(userRole))
					.build();
			UserEntity admin = UserEntity
					.builder()
					.username("admin")
					.password("1234")
					.isEnabled(true)
					.accountNonExpired(true)
					.credentialNoExpired(true)
					.roles(Set.of(adminRole))
					.build();
			UserEntity guest = UserEntity
					.builder()
					.username("guest")
					.password("1234")
					.isEnabled(true)
					.accountNonExpired(true)
					.credentialNoExpired(true)
					.roles(Set.of(guestRole))
					.build();
			UserEntity ana = UserEntity
					.builder()
					.username("ana")
					.password("1234")
					.isEnabled(true)
					.accountNonExpired(true)
					.credentialNoExpired(true)
					.roles(Set.of(developerRole))
					.build();
			// Guardar usuarios - Creamos el repositorio
            /*
            userRepository.save(juan);
            userRepository.save(jose);
            userRepository.save(admin);
            userRepository.save(ana);

             */
			userRepository.saveAll(List.of(juan, jose,admin, guest, ana));

		};
	}
}
