/* ************************************************************************** */
/*                                                                            */
/*                                                        :::      ::::::::   */
/*   iterative_factorial.c                              :+:      :+:    :+:   */
/*                                                    +:+ +:+         +:+     */
/*   By: lroux <marvin@42.fr>                       +#+  +:+       +#+        */
/*                                                +#+#+#+#+#+   +#+           */
/*   Created: 2018/07/06 14:37:24 by lroux             #+#    #+#             */
/*   Updated: 2019/10/28 00:16:33 by lroux            ###   ########.fr       */
/*                                                                            */
/* ************************************************************************** */

int		iterative_factorial(int nb)
{
	int i;
	int factorial;

	if (nb < 0 || nb > 12)
		return (0);
	if (nb == 0)
		return (1);
	i = 1;
	factorial = 1;
	while (i <= nb)
	{
		factorial *= i;
		i++;
	}
	return (factorial);
}
