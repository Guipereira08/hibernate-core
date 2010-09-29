/*
 * Hibernate, Relational Persistence for Idiomatic Java
 *
 * Copyright (c) 2010, Red Hat, Inc. and/or its affiliates or third-party contributors as
 * indicated by the @author tags or express copyright attribution
 * statements applied by the authors.  All third-party contributions are
 * distributed under license by Red Hat, Inc.
 *
 * This copyrighted material is made available to anyone wishing to use, modify,
 * copy, or redistribute it subject to the terms and conditions of the GNU
 * Lesser General Public License, as published by the Free Software Foundation.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY
 * or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU Lesser General Public License
 * for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with this distribution; if not, write to:
 * Free Software Foundation, Inc.
 * 51 Franklin Street, Fifth Floor
 * Boston, MA  02110-1301  USA
 */
package org.hibernate.test.annotations.various.readwriteexpression;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.ReadWriteExpression;

/**
 * @author Emmanuel Bernard
 */
@Entity
@Table(name="t_staff")
public class Staff {

	public Staff(double sizeInInches, double radius, Integer id) {
		this.sizeInInches = sizeInInches;
		this.radiusS = radius;
		this.id = id;
	}

	@Id
	public Integer getId() { return id; }
	public void setId(Integer id) {  this.id = id; }
	private Integer id;

	@Column(name="size_in_cm")
	@ReadWriteExpression(
			forColumn = "size_in_cm",
			read = "size_in_cm / 2.54",
			write = "? * 2.54" )
	public double getSizeInInches() { return sizeInInches; }
	public void setSizeInInches(double sizeInInches) {  this.sizeInInches = sizeInInches; }
	private double sizeInInches;

	@ReadWriteExpression(
			read = "radiusS / 2.54",
			write = "? * 2.54" )
	public double getRadiusS() { return radiusS; }
	public void setRadiusS(double radiusS) {  this.radiusS = radiusS; }
	private double radiusS;
}