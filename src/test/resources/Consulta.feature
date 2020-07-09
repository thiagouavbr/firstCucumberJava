#language: pt
Funcionalidade: Consulta de curso
	
	Cenario: Caminho Feliz
		Dado que o usuario acessa o site da Iterasys
		Quando realizo uma busca por "teste de software"
		Entao exibe um conjunto de cursos
		Quando o usuario clica no Curso Inicio Rapido em Teste de Software
		Entao valido que a duracao do curso sera de "060 Horas de duração"
		 