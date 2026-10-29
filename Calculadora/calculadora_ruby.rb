puts "Calculadora"
puts "-----------"

puts "Escolha a operacao!"
puts "1 Adicao"
puts "2 Subtracao"
puts "3 Divisao"
puts "4 Multiplicacao"

puts "Digite um numero?"
n1 = gets.chomp().to_f

puts "Digite o Numero da Operacao escolhida?"
operacao = gets.chomp().to_i

puts "Digite o segundo numero?"
n2 = gets.chomp().to_f

if operacao == 1
	sum = n1 + n2
	puts "#{n1} + #{n2} = #{sum}"
elsif operacao == 2
	menos = (n1 - n2) * -1 
	puts "#{n1} - #{n2} = #{menos}"
elsif operacao == 3
	if n2 != 0
		div = n1 / n2
		puts "#{n1} / #{n2} = #{div.round(2)}"
	else
		puts "Divisao Invalida! Numero nao pode ser dividido por 0!"
	end
elsif operacao == 4
	multi = n1 * n2
	puts "#{n1} * #{n2} = #{multi}"
end